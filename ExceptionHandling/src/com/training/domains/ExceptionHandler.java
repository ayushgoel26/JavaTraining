package com.training.domains;

public class ExceptionHandler {
	
	public static String handle(){
		try{
			
			String args = "45";
			int age = Integer.parseInt(args);
			int markScored = 350; 
			int average = markScored/0;
			System.out.println(age);
			System.out.println(average);
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("LOL-Args");
			e.printStackTrace();
		}
		catch (NumberFormatException e){
			System.out.println("LOL-Number");
			e.printStackTrace();
		}
		catch (ArithmeticException e){
			System.out.println("LOL-divide by 0");
			e.printStackTrace();			
			return "bye bye";

		}
		finally{
			System.out.println("\n Final Done");
		}
		return "Bye"; 
	}
			
		public static String catchwithJava8(){
			try{
				
				String args = "45";
				int age = Integer.parseInt(args);
				int markScored = 350; 
				int average = markScored/0;
				System.out.println(age);
				System.out.println(average);
			}
			catch (ArrayIndexOutOfBoundsException |NumberFormatException | ArithmeticException e){
				System.out.println(e.getClass());
				e.printStackTrace();
			}
			finally{
				System.out.println("\n Final Done");
			}
			return "Bye"; 
		}
	
	public static void main(String[] args) {
		//handle();
		catchwithJava8();
		
	}
}