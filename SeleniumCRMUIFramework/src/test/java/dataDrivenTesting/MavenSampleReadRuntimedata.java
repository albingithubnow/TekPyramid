package dataDrivenTesting;

public class MavenSampleReadRuntimedata {

	public static void main(String[] args) {
		System.out.println(args.length);
			for (String var : args) {
				System.out.println(var);
			}
	}// right click, run as, run configurations, pass parameters in arguments 

}
