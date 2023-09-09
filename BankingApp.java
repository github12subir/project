import java.util.*;

class BankDetails{

    private String ac_no;
    private String name;
    private String ac_Type;
    private double balance;
	
	
	Scanner sc= new Scanner(System.in);

    //Method to create new Accounts
    public void openAccounts(){
        System.out.println("Enter account Number");
        this.ac_no=sc.next();

        System.out.println("Enter Name of the Account Holder");
        this.name=sc.next();

        System.out.println("Enter Account Type");
        this.ac_Type=sc.next();

        System.out.println("Enter initial balance");
        this.balance=sc.nextDouble();
		
    }

    //method to display account details
    public void show(){
        System.out.println("Account number : "+ac_no);
        System.out.println("Account Holder name : "+name);
        System.out.println("Account Type : "+ac_Type);
        System.out.println("Account balance = "+balance);
    }

    //method to deposite money
    public void deposite(){
        System.out.println("Enter Amount you want to deposite :");
        double amt=sc.nextDouble();
        balance+=amt;
        System.out.println("Deposite completed "+"your new balance is = "+balance);
    } 

    //method to withdraw money
    public void withdraw(){
        System.out.println("Enter the amount you want to withdraw :");
        double amt=sc.nextDouble();
        if(balance>=amt){
            balance-=amt;
            System.out.println("wthdraw completed "+"your new balance is = "+balance);
        }else{//(balance<amt)
            System.out.println("Transaction failed! "+"your balance is less than "+amt);

        }
    }

    //method to search an account by accno
    public boolean search(String accno){
        if(ac_no.equals(accno)){
            show();
            return true;
        }
        return false;
    }


}

//public class
public class BankingApp{
    public static void main(String args[]){

        //create initial account
        Scanner sc= new Scanner(System.in);
        System.out.println("how many account you want to add :");
        int n=sc.nextInt();

        BankDetails obj[]=new BankDetails[n];

        for(int i=0;i<obj.length;i++){
            obj[i]=new BankDetails();
            obj[i].openAccounts();
        }
        int opt;
        do{
        //choice the option and perform specific operation
            System.out.println("***Welcome to our Banking Application***");
            System.out.println("1.Display all Account Details");
            System.out.println("2.search Account details by Acount number");
            System.out.println("3.Deposite Money");
            System.out.println("4.withdraw Money");
            System.out.println("5.Exit");
            System.out.println("Enter your choice : ");
                opt=sc.nextInt();
                switch (opt) {
                    case 1:
                        for(int i=0;i<obj.length;i++){
                            obj[i].show();
                        }
                        break;
                
                    case 2:
                        System.out.println("Enter Account number you want to search");
                        String accno=sc.next();
                        boolean found=false;
                        for(int i=0;i<obj.length;i++){
                            found=obj[i].search(accno);
                            if(found){
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("search faild! account doesn't exit!");

                        }
                        
                        break;
                    case 3:
                        System.out.println("Enter account number : ");
                         accno=sc.next();
                         found=false;
                        for(int i=0;i<obj.length;i++){
                            found=obj[i].search(accno);
                            if(found){
                                obj[i].deposite();
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("search faild! Account doesn't exit!");
                            
                        }
                        break;
                    case 4:
                        System.out.println("Enter account number : ");
                        accno=sc.next();
                        found=false;
                        for(int i=0;i<obj.length;i++){
                            found=obj[i].search(accno);
                            if(found){
                                obj[i].withdraw();
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("search faild! Account doesn't exit!");
                            
                        }
                        break;
                    case 5:
                        System.out.println("See you soon...");
                        break;
                }
            
        }while(opt!=5);
    }
}