// Generated from br/ufscar/dc/compiladores/alguma/lexico/AlgumaLexer.g4 by ANTLR 4.12.0
package br.ufscar.dc.compiladores.alguma.lexico;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlgumaLexerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlgumaLexerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(AlgumaLexerParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(AlgumaLexerParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(AlgumaLexerParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(AlgumaLexerParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(AlgumaLexerParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(AlgumaLexerParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(AlgumaLexerParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(AlgumaLexerParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(AlgumaLexerParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(AlgumaLexerParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(AlgumaLexerParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(AlgumaLexerParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(AlgumaLexerParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(AlgumaLexerParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(AlgumaLexerParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(AlgumaLexerParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(AlgumaLexerParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(AlgumaLexerParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(AlgumaLexerParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(AlgumaLexerParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(AlgumaLexerParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(AlgumaLexerParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(AlgumaLexerParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(AlgumaLexerParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(AlgumaLexerParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(AlgumaLexerParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(AlgumaLexerParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(AlgumaLexerParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(AlgumaLexerParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(AlgumaLexerParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(AlgumaLexerParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(AlgumaLexerParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(AlgumaLexerParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(AlgumaLexerParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(AlgumaLexerParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(AlgumaLexerParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(AlgumaLexerParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(AlgumaLexerParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(AlgumaLexerParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(AlgumaLexerParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(AlgumaLexerParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(AlgumaLexerParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(AlgumaLexerParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(AlgumaLexerParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(AlgumaLexerParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(AlgumaLexerParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(AlgumaLexerParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(AlgumaLexerParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(AlgumaLexerParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link AlgumaLexerParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(AlgumaLexerParser.Op_logico_2Context ctx);
}