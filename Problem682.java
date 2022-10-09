//682. Baseball Game

class Solution {
    public int calPoints(String[] operations) {
      
        int sum = 0;
      
		Stack<Integer> stack = new Stack<>();
      
		for (String s : operations) {
      
			if (s.equals("C")) {
        
				sum = sum - stack.pop();
        
			} else if (s.equals("D")) {
        
				sum += 2 * stack.peek();
        
				stack.push(2 * stack.peek());

			} else if (s.equals("+")) {
        
				int temp = stack.pop();
        
				int newval = stack.peek() + temp;
        
				stack.push(temp);
        
				stack.push(newval);
        
				sum += newval;
        
			} else {
        
				int val = Integer.parseInt(s);
        
				stack.push(val); 
        
				sum += val;
			}
		}
		return sum;
    }
}
