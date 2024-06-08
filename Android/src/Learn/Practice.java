package Learn;


public class Practice {

	public static void main(String[] args) {
		int count=0;

		for(int i=1;i<=5;i++) {
			
			
			for(int j=i;j>=1;j--) {
				count++;

				System.out.print(count);
			}
			System.out.println("");
		}
	}
}
