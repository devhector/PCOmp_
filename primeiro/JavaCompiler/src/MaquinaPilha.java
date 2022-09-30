import java.io.*;

class MaquinaPilha{
	public static void main(String[] argv)
	{
		BufferedReader r;
		Operation op = new Operation();
		try
		{
			r = new BufferedReader(new FileReader(argv[0]));
			String line = r.readLine();
			while (line != null)
			{
				op.run(line);
				line = r.readLine();
			}
			r.close();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao abrir arquivo" + e);
			return;
		}
	}
}

class Operation
{
	String [] op = new String[2];
	int a, b;
	Stack stack = new Stack(1000);

	void run(String op)
	{
		this.op = op.split(" ");
		if (this.op[0].equals("PUSH"))
		{
			stack.push(Integer.parseInt(this.op[1]));
		}
		else if (this.op[0].equals("SUM"))
		{
			b = stack.pop();
			a = stack.pop();
			stack.push(a + b);
		}
		else if (this.op[0].equals("SUB"))
		{
			a = stack.pop();
			b = stack.pop();
			stack.push(b - a);
		}
		else if (this.op[0].equals("MULT"))
		{
			a = stack.pop();
			b = stack.pop();
			stack.push(a * b);
		}
		else if (this.op[0].equals("DIV"))
		{
			b = stack.pop();
			a = stack.pop();
			stack.push(a / b);
		}
		else if (this.op[0].equals("PRINT"))
		{
			System.out.println(stack.pop());
		}
	}
}

class Stack
{
	private int[] stack;
	private int top;
	
	Stack(int size)
	{
		stack = new int[size];
		top = -1;
	}

	void print()
	{
		for (int i = 0; i <= top; i++)
			System.out.print(stack[i] + " ");
		System.out.println();
	}
	
	void push(int value)
	{
		stack[++top] = value;
	}
	
	int pop()
	{
		return stack[top--];
	}
	
	int top()
	{
		return stack[top];
	}
	
	boolean isEmpty()
	{
		return top == -1;
	}
}
