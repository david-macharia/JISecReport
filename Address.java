package address;

import com.itextpdf.text.Rectangle;

import report.Report;

/*
 * School postal address
 * byDefault the  report form must have a school name,
 * and postal address
 * 
 */
public class Address {
	//declare private data for the addresses
	private SchoolName school_name;
	private PhoneNumber phone_number;
	
	private Email email;
	private P_O_Box p_o_box;
	public Address(){
		school_name= new SchoolName();
		phone_number= new PhoneNumber();
		email= new Email();
		p_o_box= new P_O_Box();
		setDynamicStep();
		
	}
	//get the p.o box object
  public  P_O_Box getP_O_Box(){
	  return p_o_box;
  }
  //accept a p-obox object and replace the default
	public void setP_O_Box(P_O_Box p_o_box){
		this.p_o_box=p_o_box;
	}
	//get the address position as a rectangle
	//with the bottom left as the start point
	public Rectangle getAddressPosition(){
		
		return new Rectangle(0,0);
	}
	//set the andress position
	public void setAddressPosition(Rectangle address_position){
		
	}
	//set the school name
	public void setSchoolName(String name){
		this.school_name.setSchoolName(name);
		
	}
	//set the poition of the school name;
	public void setSchoolNamePosition(Rectangle position){
		this.school_name.setPosition(position);
	}
	//set the school phone number
   public void setPhoneNumber(String phone_number){
	   this.phone_number.setPhoneNumber(phone_number);
	   
   }
   //set the phone object accepting it from the method interface
   public void setPhone(PhoneNumber phone){
	   this.phone_number=phone;
   }
  // set the eamil object from the method interface
   public void setEmail(Email email){
	   this.email=email;
	   
	   
   }
  //set the location of the postal name
   public void setLocation(String location){
	   this.p_o_box.setPostalName(location);
   }
  //the postal andress i:e the name,postal number,box_number
   public void setPostalAndress(String name,int postal_number,int box_number){
	   if(name==null){
		 this.p_o_box.setPostalName(" ");  
	   }else{
		  this.p_o_box.setPostalName(name);
		  this.p_o_box.setPostalNumber(postal_number);
		  this.p_o_box.setBoxNumber(box_number);
	   }
	   
   }
   //get the email object
   public Email  getEmail(){
	   return email;
   }
   //set the email object
   public void setEmailAddress(String name){
	   email.setName(name);
   }
   //get the email object
   public String getEmailAddress(String name){
	  return email.getName();
   }
   //get the school name
   public String getSchoolName(){
	   return school_name.getSchoolName();
   }
   //get the phone number
   public String getPhoneNumber(){
	   return phone_number.getPhoneNumber();
   }
   //get the phonenuber object
   public PhoneNumber getPhone(){
	   return phone_number;
   }
   //get the location of the postal name
   public String getLocation(){
	   return p_o_box.getPostalName();
   }
   //get the whole address i.e number,postal name and postal number
   public String getPostalAndress(){
	   return "P.O.Box "+" "+p_o_box.getBoxNumber()+" "+p_o_box.getPostalName()+" \n("+p_o_box.getPostalNumber()+")";
   }
  //get the school object
   public SchoolName getSchool(){
	   return school_name;
   }
   //dynamically aligns the address based on the page size choosen
   private void setDynamicStep(){
	  int height= (int) Report.getReportSize().getHeight();
	  this. getPhone().setStep(height/80);
	   this.getSchool().setStep(height/130);
	   this.getEmail().setStep(height/60);
	   this.getP_O_Box().setStep(height/43);
   }
}
