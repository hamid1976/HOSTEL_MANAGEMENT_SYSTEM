/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

/**
 *
 * @author Dell
 */
public class HostelAllotementBean {
   
    
        private int  hostelId;
        private int  allotementId;
        private int  batchId;
        private int  part;
	private String rollNo;
	private java.util.Date dateOfAllotement;
	private int challanNo;
	private java.util.Date challanDate;
	private int challanAmout;
        private int roomNo;
        private String remarks;
	
	public void seHostelId(int hostelId){
		this.hostelId=hostelId;
	}
        
        public void seAllotementId(int allotementId){
		this.allotementId=allotementId;
	}
        
        
         public void seBatchId(int batchId){
		this.batchId=batchId;
	}
        

	public void setPart(int part){
		this.part=part;
	}

	public void setRollNo(String rollNo){
		this.rollNo=rollNo;
	}

         public void setDateOfAllotement(java.util.Date dateOfAllotement ){
                this.dateOfAllotement=dateOfAllotement;
        }

         public void setChallanNo(int challanNo){
                this.challanNo=challanNo;
        }  
         
          public void setChallanDate(java.util.Date challanDate){
  	this.challanDate=challanDate;
  }

           
          public void setChallanAmout(int challanAmout){
  	this.challanAmout=challanAmout;
  }

        public void setRoomNo(int roomNo){
            this.roomNo=roomNo;
  }
  
        public void setRemarks(String remarks){
                this.remarks=remarks;
            }


 	public int gseHostelId(){
		return hostelId;
	}
        
        public int geAllotementId(){
		return allotementId;
	}
         public int geBatchId(){
		return batchId;
	}
        
	public int getPart(){
		return part;
	}

	public String getRollNo(){
		return rollNo;
	}

         public java.util.Date getDateOfAllotement(){
                return dateOfAllotement;
        }

         public int getChallanNo(){
                return challanNo;
        }  
         
          public java.util.Date gsetChallanDate(){
                return challanDate;
        }

           
          public int getChallanAmout(){
            return challanAmout;
        }

        public int getRoomNo(){
            return roomNo;
  }
  
        public String getRemarks(){
                return remarks;
            }

   

 
  


public String toString(){
	return rollNo;
}




}

