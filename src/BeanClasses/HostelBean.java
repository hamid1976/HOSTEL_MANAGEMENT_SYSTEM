/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;
public class HostelBean{

        private int  hostelId;
	private String hostelName;
	private String num_Of_Rooms;
	private String room_Size;
	private String stud_Per_Room;
	private String No_Of_Washrooms;
        private String remarks;
	



	public void seHostelId(int hostelId){
		this.hostelId=hostelId;
	}

	public void setHostelName(String hostelName){
		this.hostelName=hostelName;
	}

	public void setNumOfRooms(String num_Of_Rooms){
		this.num_Of_Rooms=num_Of_Rooms;
	}

         public void setRoomSize(String room_Size){
                this.room_Size=room_Size;
        }

         public void setStudPerRoom(String stud_Per_Room){
                this.stud_Per_Room=stud_Per_Room;
        }  
         
          public void setNoOfWashrooms(String No_Of_Washrooms){
  	this.No_Of_Washrooms=No_Of_Washrooms;
  }

         
  
        public void setRemarks(String remarks){
                this.remarks=remarks;
            }

   

 
  



 	public int  getHostelId(){
		return hostelId;
	}

	public String getHostelName(){
		return hostelName;
	}

	public String getNumOfRooms(){
		return num_Of_Rooms;
	}

         public String  getRoomSize(){
                return room_Size;
        }

         public String getStudPerRoom(){
                return stud_Per_Room;
        }  
         
          public String getNoOfWashrooms(){
            return No_Of_Washrooms;
  }

         
  
        public String setRemarks(){
                 return remarks;
            }

   

 
  


public String toString(){
	return hostelName;
}




}