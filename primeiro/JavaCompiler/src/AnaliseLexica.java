import java.io.*;

enum TokenType{ NUM, SOMA, SUB, DIV, MULT, APar, FPar, EOF}

class Token{
  int lexema;
  TokenType token;

 Token (int l, TokenType t)
 	{ lexema=l;token = t;}

}

class AnaliseLexica {

	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
		this.arquivo = new PushbackReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		int eof = -1;
		char currchar;
		String currstring = "";
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
				if (currchar >= '0' && currchar <= '9')
				{
					do{
						currstring += currchar;
						currchar1 =  arquivo.read();
						currchar = (char) currchar1;
					} while (currchar >= '0' && currchar <= '9' && currchar1 != eof);
					if (currchar1 != eof)
						arquivo.unread(currchar1);
					return (new Token (Integer.parseInt(currstring), TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							return (new Token (currchar,TokenType.APar));
						case ')':
							return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (currchar,TokenType.SOMA));
						case '-':
							return (new Token (currchar,TokenType.SUB));
						case '*':
							return (new Token (currchar,TokenType.MULT));
						case '/':
							return (new Token (currchar,TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}
			arquivo.close();
		return (new Token(currchar,TokenType.EOF));
	}
}
