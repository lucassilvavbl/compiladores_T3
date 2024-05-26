/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package br.ufscar.dc.compiladores.alguma.lexico;

import br.ufscar.dc.compiladores.alguma.lexico.TabelaDeSimbolos.TipoAlguma;
import org.antlr.v4.runtime.Token;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.compiladores.alguma.lexico.AlgumaLexerParser.Exp_aritmeticaContext;
/**
 *
 * @author chris
 */
public class ALSemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionaErroSemantico(Token tokones, String mensagem){
        int linha = tokones.getLine();
        
        if(!errosSemanticos.contains("Linha " + linha + ": " + mensagem)){
            errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
        }
    }
    
    public static boolean verificaCompatibilidade(TipoAlguma T1, TipoAlguma T2){
        boolean possivel = false;

        if(T1 == TipoAlguma.INTEIRO && T2 == TipoAlguma.REAL){
            possivel = true;
        }
        else if(T1 == TipoAlguma.REAL && T2 == TipoAlguma.INTEIRO){
            possivel = true;
        }
        else if(T1 == TipoAlguma.REAL && T2 == TipoAlguma.REAL){
            possivel = true;
        }

        return possivel;
    }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.Exp_aritmeticaContext ctx){
        TipoAlguma tipoRetorno = verificarTipo(tabela, ctx.termo().get(0));
        for(var termo : ctx.termo()){
            TipoAlguma tipoAtual = verificarTipo(tabela, termo);

            if( (verificaCompatibilidade(tipoAtual,tipoRetorno)) && (tipoAtual != TipoAlguma.INVALIDO) ){
                tipoRetorno = TipoAlguma.REAL;
            }
            else{
                tipoRetorno = tipoAtual;
            }
        }
        return tipoRetorno;
    }

    public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.TermoContext ctx){
        TipoAlguma tipoRetorno = verificarTipo(tabela, ctx.fator().get(0));

        for(AlgumaLexerParser.FatorContext fator : ctx.fator()){
            TipoAlguma tipoAtual = verificarTipo(tabela, fator);

            if( (verificaCompatibilidade(tipoAtual,tipoRetorno)) && (tipoAtual != TipoAlguma.INVALIDO) ){
                tipoRetorno = TipoAlguma.REAL;
            }
            else{
                tipoRetorno = tipoAtual;
            }
        }
        return tipoRetorno;
    }


        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.FatorContext ctx){
            TipoAlguma tipoRetorno = null;
    
            for(AlgumaLexerParser.ParcelaContext parcela : ctx.parcela()){
                tipoRetorno = verificarTipo(tabela, parcela);
            }
                
            return tipoRetorno;
        }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.ParcelaContext ctx){
            if(ctx.parcela_unario() != null)
                return verificarTipo(tabela, ctx.parcela_unario());
            else
                return verificarTipo(tabela, ctx.parcela_nao_unario());
        }
        
        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.Parcela_unarioContext ctx){
            TipoAlguma tipoRetorno;
            String nome;

            if(ctx.identificador() != null){
                nome = ctx.identificador().getText();


                if(tabela.existe(nome)) tipoRetorno = tabela.verificar(nome);
                else{
                    TabelaDeSimbolos tabelaAuxiliar = AlgumaLexerSemantico.escoposAninhados.percorrerEscoposAninhados().get(AlgumaLexerSemantico.escoposAninhados.percorrerEscoposAninhados().size() - 1);
                    
                    if(!tabelaAuxiliar.existe(nome)){
                        adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " não declarado");
                        tipoRetorno = TipoAlguma.INVALIDO;
                    }
                    else{
                        tipoRetorno = tabelaAuxiliar.verificar(nome);
                    }
                }
            }
            else if(ctx.NUM_INT() != null){
                tipoRetorno = TipoAlguma.INTEIRO;
            }
            else if(ctx.NUM_REAL() != null){
                tipoRetorno = TipoAlguma.REAL;
            }
            else{
                tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));
            }

            return tipoRetorno;
        }


        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.Parcela_nao_unarioContext ctx){
            TipoAlguma tipoRetorno;
            String nome;

            if(ctx.identificador() != null){
                nome = ctx.identificador().getText();


                if(!tabela.existe(nome)){
                    adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                    tipoRetorno = TipoAlguma.INVALIDO;
                }
                else{
                    tipoRetorno = tabela.verificar(ctx.identificador().getText());
                }
            }
            else{
                tipoRetorno = TipoAlguma.LITERAL;
            }

            return tipoRetorno;
        }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.ExpressaoContext ctx){
            TipoAlguma tipoRetorno = verificarTipo(tabela, ctx.termo_logico(0));

            for(AlgumaLexerParser.Termo_logicoContext termo : ctx.termo_logico()){
                TipoAlguma tipoAtual = verificarTipo(tabela, termo);
                if (tipoRetorno != tipoAtual && tipoAtual != TipoAlguma.INVALIDO){
                    tipoRetorno = TipoAlguma.INVALIDO;
                }
            }

            return tipoRetorno;
        }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.Termo_logicoContext ctx){
            TipoAlguma tipoRetorno = verificarTipo(tabela, ctx.fator_logico(0));

            for(AlgumaLexerParser.Fator_logicoContext fator : ctx.fator_logico()){
                TipoAlguma tipoAtual = verificarTipo(tabela, fator);
                if (tipoRetorno != tipoAtual && tipoAtual != TipoAlguma.INVALIDO){
                    tipoRetorno = TipoAlguma.INVALIDO;
                }
            }

            return tipoRetorno;
        }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.Fator_logicoContext ctx){
            TipoAlguma tipoRetorno = verificarTipo(tabela, ctx.parcela_logica());
            return tipoRetorno;
        }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.Parcela_logicaContext ctx){
            TipoAlguma tipoRetorno;

            if (ctx.exp_relacional() != null){
                tipoRetorno = verificarTipo(tabela, ctx.exp_relacional());
            }
            else{
                tipoRetorno = TipoAlguma.LOGICO;
            }

            return tipoRetorno;
        }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, AlgumaLexerParser.Exp_relacionalContext ctx){
            TipoAlguma tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));

            if (ctx.exp_aritmetica().size() > 1){
                TipoAlguma tipoAtual = verificarTipo(tabela, ctx.exp_aritmetica().get(1));
                
                if(tipoRetorno == tipoAtual || verificaCompatibilidade(tipoRetorno, tipoAtual)){
                    tipoRetorno = TipoAlguma.LOGICO;
                }
                else{
                    tipoRetorno = TipoAlguma.INVALIDO;
                }
            }

            return tipoRetorno;
        }

        public static TipoAlguma verificarTipo(TabelaDeSimbolos tabela, String nomeVar){
            return tabela.verificar(nomeVar);
        }
}
