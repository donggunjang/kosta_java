import java.io.FileWriter;

class  FileWriterTest
{
	public static void main(String[] args) 
	{
		FileWriter fw = new FileWriter("c:/data/hello.txt");
		fw.write("hello java");
		fw.close();
		System.out.println("파일 생성.");
	}
}
