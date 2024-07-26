package Loops;

public class multiarray {

	public static void main(String[] args) {
		
		
		int[][]marks;
		int[][] id;
		marks=new int[2][3];
		marks[0][0]=125;
		marks[0][1]=200;
		marks[0][2]=250;
		marks[1][0]=390;
		marks[1][1]=490;
		marks[1][2]=790;
		
		for(int i=0;i<marks.length;i++) {
			for(int j=0;j<marks[i].length;j++)
			System.out.println(marks[i][j]);
		}
	}

	}