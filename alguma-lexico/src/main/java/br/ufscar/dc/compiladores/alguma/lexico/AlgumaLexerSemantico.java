/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.alguma.lexico;
import static br.ufscar.dc.compiladores.alguma.lexico.ALSemanticoUtils.verificarTipo;
import static br.ufscar.dc.compiladores.alguma.lexico.ALSemanticoUtils.adicionaErroSemantico;
import static br.ufscar.dc.compiladores.alguma.lexico.ALSemanticoUtils.verificaCompatibilidade;
import br.ufscar.dc.compiladores.alguma.lexico.TabelaDeSimbolos.TipoAlguma;
import br.ufscar.dc.compiladores.alguma.lexico.Escopos;
import org.antlr.v4.runtime.Token;
/**
 *
 * @author chris
 */
public class AlgumaLexerSemantico extends AlgumaLexerBaseVisitor<Void>{
    TabelaDeSimbolos tabela;
    
    static Escopos escoposAninhados = new Escopos();
    TabelaDeSimbolos tabelaEscopo;
    
    public void addTabela(String nome, String tipo, Token nomeT, Token tipoT){
        tabelaEscopo = escoposAninhados.obterEscopoAtual();
        
        TipoAlguma tipoItem;
        
        switch(tipo){

            case "literal":
                tipoItem = TipoAlguma.LITERAL;
                break;
            case "inteiro":
                tipoItem = TipoAlguma.INTEIRO;
                break;
            case "real":
                tipoItem = TipoAlguma.REAL;
                break;
            case "logico":
                tipoItem = TipoAlguma.LOGICO;
                break;
            default:
                tipoItem = TipoAlguma.INVALIDO;
                break;

        }
        
        if(tipoItem == TipoAlguma.INVALIDO) adicionaErroSemantico(tipoT, "tipo " + tipo + " não declarado");
        if(!tabelaEscopo.existe(nome)) tabelaEscopo.adicionar(nome, tipoItem);
        else adicionaErroSemantico(nomeT, "identificador " + nome + " já declarado anteriormente");
        
    }
    
    @Override
    public Void visitPrograma(AlgumaLexerParser.ProgramaContext ctx){
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitDeclaracoes(AlgumaLexerParser.DeclaracoesContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        
        for(AlgumaLexerParser.Decl_local_globalContext declaracao : ctx.decl_local_global()){
            visitDecl_local_global(declaracao);
        }
        
        return super.visitDeclaracoes(ctx);
    }
    
    @Override
    public Void visitDecl_local_global(AlgumaLexerParser.Decl_local_globalContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        if(ctx.declaracao_local() != null){
            visitDeclaracao_local(ctx.declaracao_local());
        }
        else if(ctx.declaracao_global() != null){
            visitDeclaracao_global(ctx.declaracao_global());
        }
        return super.visitDecl_local_global(ctx);
    }
    
    @Override
    public Void visitDeclaracao_local(AlgumaLexerParser.Declaracao_localContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        String tipoVar;
        String nomeVar;
        
        if(ctx.getText().contains("declare")){
            tipoVar = ctx.variavel().tipo().getText();
            
            
            for(AlgumaLexerParser.IdentificadorContext ident : ctx.variavel().identificador()){
                nomeVar = ident.getText();
                addTabela(nomeVar, tipoVar, ident.getStart(), ctx.variavel().tipo().getStart());
            }
        }
        
        return super.visitDeclaracao_local(ctx);
    }
    
    @Override
    public Void visitCmdEscreva(AlgumaLexerParser.CmdEscrevaContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoAlguma tipo;
        
        for(AlgumaLexerParser.ExpressaoContext expressao : ctx.expressao()){
            tipo = verificarTipo(tabela, expressao);
        }
        
        return super.visitCmdEscreva(ctx);
    }
    
    @Override
    public Void visitCmdEnquanto(AlgumaLexerParser.CmdEnquantoContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoAlguma tipo = verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdEnquanto(ctx);
    }
    
    @Override
    public Void visitCmdAtribuicao(AlgumaLexerParser.CmdAtribuicaoContext ctx){
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoAlguma tipoExpressao = verificarTipo(tabela, ctx.expressao());
        String varNome = ctx.identificador().getText();
        
        if(tipoExpressao != TipoAlguma.INVALIDO){
            if(!tabela.existe(varNome)){
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " não declarado");
            }
            else{
                TipoAlguma varTipo = verificarTipo(tabela, varNome);
                
                if(varTipo == TipoAlguma.INTEIRO || varTipo == TipoAlguma.REAL){
                    if(!verificaCompatibilidade(varTipo, tipoExpressao)){
                        if(tipoExpressao != TipoAlguma.INTEIRO){
                            adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
                        }
                    }
                }
                
                else if(varTipo != tipoExpressao) adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
            }
        }
        
        return super.visitCmdAtribuicao(ctx);
    }
    
}
