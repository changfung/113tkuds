public class bigoc {
    public static void main(String[] args) {
        int n = 10; 
        int x = 0;  
        int count=0; 
  
        for (int i = 0; i <= n; i++) {       
            for (int j = 1; j <= n; j++) {
                x = x + 1;  
                count++;
            }
        }
        System.out.println(count);  
    }
}

