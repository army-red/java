import java.util.Scanner;
import java.lang.String;
public class HW1029 {
	public static void main(String[] args) {
		int N,L;
		String s="s", es="es", ies="ies";
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		String[] ES = new String[N]; //Exception Singular
		String[] EP = new String[N]; //Exception Plural
		String[] S  = new String[L]; //Singular
		String[] P  = new String[L]; //Plural
		for(int i = 0; i <= N-1; i++) {
			ES[i]=sc.next();
			EP[i]=sc.next();
		}
		for(int i = 0; i <= L-1; i++ ) {
			S[i]=sc.next();
		}
		for(int i = 0; i <= L-1; i++ ) {
			//�ҥ~�r
			for(int j = 0; j <= N-1; j++) {
				if(S[i]==ES[j]) {
					P[i]=EP[j];
				}
			}
			String lastOfSentence = S[i].substring(S[i].length() - 1);
			String last2OfSentence = S[i].substring(S[i].length() - 2);
			//System.out.println("LAST"+lastOfSentence);
			//�[es
			if(lastOfSentence=="o" || lastOfSentence=="s" || lastOfSentence=="x" || last2OfSentence=="ch" || last2OfSentence=="sh") {
				P[i]= S[i]+es;
				System.out.println("p: " + P[i]);
			}
			//�hy�[ies
			else if("y".equals(lastOfSentence) && !"ay".equals(last2OfSentence) && !"ey".equals(last2OfSentence) && !"iy".equals(last2OfSentence) && !"oy".equals(last2OfSentence) && !"uy".equals(last2OfSentence)) {
				System.out.println("in to the y");
				P[i]=S[i].substring(0,S[i].length()-1)+ies;
				System.out.println("����"+S[i].substring(0,S[i].length()-1));
			}
			//�[s
			/*else {
				P[i]=S[i]+s;
			}*/
		}

		System.out.println("============================");
		for(int i = 0; i <= L-1; i++) {
			System.out.println("P"+P[i]);
			System.out.println("ES"+ES[i]);
			System.out.println("EP"+EP[i]);
		}

	}
}
