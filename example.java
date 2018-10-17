
class A
{
  public void do()
  {
    System.out.println("A");
  }
  
  public void do(String str)
  {
    System.out.println(str);
  }
  
 }
 
class B 
{
  public static void main(String[] args) 
  {
    A object = new A();
    object.do("B");
  }
  
 }
