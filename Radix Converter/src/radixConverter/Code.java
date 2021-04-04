package radixConverter;

public class Code {
	public static int binToDec(int n)
	{
		int num = n;
		int dec_value = 0;
		int base = 1;

		int temp = num;
		while (temp > 0) {
			int last_digit = temp % 10;
			temp = temp / 10;

			dec_value += last_digit * base;

			base = base * 2;
		}

		return dec_value;
	}

	public static StringBuffer decToBin(int n) 
	    { 
	        int[] binaryNum = new int[32]; 
	        StringBuffer output = new StringBuffer();
	        int i = 0; 
	        while (n > 0) { 
	            binaryNum[i] = n % 2; 
	            n = n / 2; 
	            i++; 
	        } 
	  
	        for (int j = i - 1; j >= 0; j--) { 
	            output.append(binaryNum[j]);
	        }
			return output;
	    } 
	  
	   
	 public static StringBuffer decToHex(int n) 
		{ 
			char[] hexaDeciNum = new char[100]; 
			StringBuffer output = new StringBuffer();
			int i = 0;
			
			while(n!=0) 
			{ 
				int temp = 0; 
			
				temp = n % 16; 
			
				if(temp < 10) 
				{ 
					hexaDeciNum[i] = (char)(temp + 48); 
					i++; 
				} 
				else
				{ 
					hexaDeciNum[i] = (char)(temp + 55); 
					i++; 
				} 
			
				n = n/16; 
			} 
		
			for(int j=i-1; j>=0; j--) {
				output.append(hexaDeciNum[j]);}
			
			return output;
		} 
	   	
	    
	 public static StringBuffer decToOct(int n)
	    {
	        int[] octalNum = new int[100];
	        StringBuffer output = new StringBuffer();
	        int i = 0;
	        while (n != 0) {
	            octalNum[i] = n % 8;
	            n = n / 8;
	            i++;
	        }
	 
	        for (int j = i - 1; j >= 0; j--) {
	            output.append(octalNum[j]);}
	        return output;
	    }
		 
	 public static int hexToDec(String hexVal) 
		{ 
			int len = hexVal.length(); 
		
			int base = 1; 
		
			int dec_val = 0; 
		
			for (int i=len-1; i>=0; i--) 
			{ 
				
				if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') 
				{ 
					dec_val += (hexVal.charAt(i) - 48)*base; 
					
					base = base * 16; 
				} 

			
				else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') 
				{ 
					dec_val += (hexVal.charAt(i) - 55)*base; 
			
					base = base*16; 
				} 
			}
			return dec_val;
		
		} 
		
			
	 public static int octToDec(int n) 
		{ 
			int num = n; 
			int dec_value = 0; 

			int base = 1; 

			int temp = num; 
			while (temp > 0) { 
				
				int last_digit = temp % 10; 
				temp = temp / 10; 

		
				dec_value += last_digit * base; 

				base = base * 8; 
			} 
			return dec_value; 
		} 
	
	    
}	    