class Solution {
    
    HashMap<String,Integer> mmap=new HashMap<String,Integer>();
    
    public Solution()
    {
      mmap.put("0",0);
      mmap.put("10",1);
      mmap.put("20",1);
    }
    
    
    
    public int numDecodings(String s) {
        
        if(mmap.containsKey(s))
            return mmap.get(s);
        
        if(s.length()==0)
        return 0;
        
        int fch=s.charAt(0)-'0';
        
        if(fch==0)
        return 0;
       
        if(s.length()==1)
            return 1;
            
        int result=0;
        
        if(fch==1 || (fch==2 && (s.charAt(1)-'0')<7))
        {
            if(s.length()==2)
            {
                result=2;
            }
            else 
            result=numDecodings(s.substring(1))+numDecodings(s.substring(2));
        }
        else
            result=numDecodings(s.substring(1));
        
        if(!mmap.containsKey(s))
            mmap.put(s,result);
        
        return result;
            
    }
}