package date04262020;

public class Array2Dimension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] data = new int[2][2];
		data[0][0] = 1;
		data[0][1] = 2;
		data[1][0] = 3;
		data[1][1] = 4;

		System.out.println(data[0][0] + "\t" + data[0][1]);
		System.out.println(data[1][0] + "\t" + data[1][1]);

		System.out.println("--------------------------------------------\n");
		// practice 10 15 20
		// 25 30 35
		int[][] data1 = new int[2][3];
		data1[0][0] = 10;
		data1[0][1] = 15;
		data1[0][2] = 20;
		data1[1][0] = 25;
		data1[1][1] = 30;
		data1[1][2] = 35;

		System.out.println(data1[0][0] + "\t" + data1[0][1] + "\t" + data1[0][2]);
		System.out.println(data1[1][0] + "\t" + data1[1][1] + "\t" + data1[1][2]);

		
		//using loop not above (hard code)
		System.out.println("\n----------------------2 dimension array using loop-----------------");
		for (int row = 0; row < data1.length; row++) {
			for (int col = 0; col < data1[row].length; col++) {
				System.out.print(data1[row][col] + " ");
			}
System.out.println();
		}

	}
}
