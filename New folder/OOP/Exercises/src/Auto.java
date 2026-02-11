
class Auto {
  private String brandModel;
  private int manufacturingYear;
  private int engineCapacity; 
  private ThePerson2 owner;
  
  public Auto(String brandModel, int manufacturingYear, int engineCapacity, ThePerson2 owner){   
    this.brandModel = brandModel;
    this.manufacturingYear = manufacturingYear;
    this.engineCapacity = engineCapacity;
    this.owner = owner;
  }

  public String getBrandModel(){
    return brandModel;  
  }

  public int getManYear(){
    return manufacturingYear;  
  }

  public int getEngCapacity(){
	 return engineCapacity;  
  }
	  
  public ThePerson2 getOwner(){
	  return owner;  
  }

   public String toString(){
	   return String.format("%s %d %d\n", getBrandModel(), getManYear(), getEngCapacity());  
   }

    public void setOwner(ThePerson2 owner){
	   this.owner =  owner;
	}
}

