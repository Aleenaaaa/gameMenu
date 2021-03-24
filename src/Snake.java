
public class Snake   {
	 int start;                         // This is where I described the beginning and the end of the snake object.
	  int end;
	  public Snake(int s,int e){
	    if(s>e){                             // This is the constructor, where if the one value if greater than the other, the biggest one is start and the smallest one is the end.
	    start=s;                             // The Start is always bigger than the End in the snake object.
	      end=e;
	    }else{
	      start=e;
	      end=s;
}
}
}
