
public class Ladder {                                   //This is where I described the Ladder object. The start of the ladder is always smaller than the end of the ladder.
	int start;
	int end;
	
	public Ladder(int s, int e) {                        //So if one of the value is bigger than the other value, the smaller value is always the start position of the ladder 
		if ( s<e) {                                      // And the bigger value is the end of the ladder.
			s = start;
			e = end;
		} else {
			s = end;
			e = start;
	}

	
}  

}
