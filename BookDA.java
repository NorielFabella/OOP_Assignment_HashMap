

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BookDA
{
    private HashMap<String, Author> authorMap;

    public BookDA() throws FileNotFoundException
    {

        
        try
        {
            Scanner bookInfo = new Scanner (new FileReader("Book.csv"));
            bookInfo.nextLine();
           
            
            while(bookInfo.hasNext())
            {

                authorMap = new HashMap<>();
                String rowBook = new String();

                rowBook = bookInfo.nextLine();

                String[] rowBookSplit = new String[3];

                rowBookSplit = rowBook.split(",");

                Book book = new Book();

                book.setIsbn(rowBookSplit[0].trim());
                book.setTitle(rowBookSplit[1].trim());
                book.setAuthor(rowBookSplit[2].trim());
                AuthorDA authorDA = new AuthorDA(book.getAuthor());
                authorMap = authorDA.getAuthorMap();
                
                book.setAuthorMap(authorDA.getAuthorMap());
                


                System.out.print(book.getIsbn() + " ");
                System.out.print(book.getTitle() + "\n\t");
                
                //System.out.print(book.getAuthorName() + " - ");

                //System.out.println(authorMap + "I showed map");
                for(Map.Entry<String, Author> authorMap: book.getAuthorMap().entrySet())
                {
                    if(authorMap.getValue().name != null)
                    {
                        System.out.print(authorMap.getValue().getName() + " - ");
                        System.out.println(authorMap.getValue().getBio() + "\n");
                    }
                    
                    
                    
                }
              //  System.out.println(authorDA.getAuthorMap());



            }
        }
        catch(FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }
}
