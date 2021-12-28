package com.springBoot.hibernateDemo.model;


    import java.util.regex.Matcher;
import java.util.regex.Pattern;
  
public class HtmlTagValidator{
  
   private Pattern pattern;
   private Matcher matcher;
  
   private static final String HTML_TAG_FORMAT_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
  
   public HtmlTagValidator(){
      pattern = Pattern.compile(HTML_TAG_FORMAT_PATTERN);
   }
  
  
  public boolean validate(final String tag){
  
    System.out.println("**");
      matcher = pattern.matcher(tag);
      return matcher.matches();
  
  }

  public static void main(String[] agrs){

    HtmlTagValidator htmlTagValidator=new HtmlTagValidator();
    htmlTagValidator.validate("anil");
    System.out.println( htmlTagValidator.validate("anil"));

  }
}
  