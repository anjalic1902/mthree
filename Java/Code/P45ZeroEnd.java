public class P45ZeroEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 3, 4, 0}; 
        int zeroCount = 0;

    
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;  
            }
        }

     
        int[] newArray = new int[arr.length];  
        int index = 0;  

     
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray[index++] = arr[i];  
            }
        }

      
        for (int i = index; i < newArray.length; i++) {
            newArray[i] = 0;  
        }

      
        System.out.print("Output: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);  
        }
    }
}