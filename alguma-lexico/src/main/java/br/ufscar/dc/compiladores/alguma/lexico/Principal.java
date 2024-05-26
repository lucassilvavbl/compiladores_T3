
package br.ufscar.dc.compiladores.alguma.lexico;

// Importações básicas para o funcionamento do programa.
import br.ufscar.dc.compiladores.alguma.lexico.AlgumaLexerParser.ProgramaContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Principal {

    public static void main(String args[]) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(args[1]))) {
            try {
                CharStream cs = CharStreams.fromFileName(args[0]);
                
                // Inicialização do analisador léxico.
                AlgumaLexerLexer lexer = new AlgumaLexerLexer(cs);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                
                // Inicialização do analisador sintático.
                AlgumaLexerParser parser = new AlgumaLexerParser(tokens);
                ProgramaContext arvore = parser.programa();
                AlgumaLexerSemantico t3s = new AlgumaLexerSemantico();
                
                // Inicialização do programa.
                t3s.visitPrograma(arvore);
                ALSemanticoUtils.errosSemanticos.forEach((s) -> pw.println(s));
                pw.println("Fim da compilacao");
                pw.close();                
            } catch (RuntimeException e) {
            }
        }
    }
}