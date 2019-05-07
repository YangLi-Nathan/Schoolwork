import java.util.Scanner;

/*Student Name: Yang Li			Data:06/14/2017
 * Title of the Program: ChrisTree
 * Write a program named ChrisTree that produces images of CHristmas trees as output.*/
public class ChrisTree {
	public static void main(String[] args){
		tree(3,4);
	}
	
	public static void tree (int numberSegment, int height){
		String[] leftTree= new String[height];
		String[] storeSpace = new String[height];
		
		int i = 0;
		int j = 0;
		int z=0;
		
		String space = " ";
		String aerik="*";
		
		while (i< height){
			space = space+" ";
			i++;
		}
		while (z<height){
			storeSpace[z]=space.substring(0, space.length()-z);
			z++;
		}
		
		while(j<height){
			leftTree[j]=aerik;
			if(j<height){
				aerik = aerik+"**";
			}
			j++;
		}
		int segment = 0;
		int x= 0;
		while(segment<numberSegment){
			for(x=0;x<leftTree.length;x++){
				System.out.println(storeSpace[x]+leftTree[x]);
			}
			x=0;
			segment++;
			for(int y = 0;y<leftTree.length;y++){
				leftTree[y]=leftTree[y]+"*";
			}
		}
		int botTree =0;
		while(botTree<2){
			System.out.println("      "+"*");
			botTree++;
		}
		System.out.println(storeSpace[3]+" *******");
		
	}
}