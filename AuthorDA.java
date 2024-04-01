
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AuthorDA
{
    private HashMap<String, Author> authorMap;

    public HashMap<String, Author> getAuthorMap()
    {
        return authorMap;
    }

    public void setAuthorMap(HashMap<String, Author> authorMap)
    {
        this.authorMap = authorMap;
    }

    public AuthorDA(String name) throws FileNotFoundException
    {
        try
        {
            Scanner authorInfo = new Scanner(new FileReader("Author.csv"));
            authorMap = new HashMap<String, Author>();

            authorInfo.nextLine();
            Integer key = 0;
            


            while(authorInfo.hasNext())
            {
                String rowAuthor = new String();

                rowAuthor = authorInfo.nextLine();

                String[] rowAuthorSpecific = new String[2];

                rowAuthorSpecific = rowAuthor.split(",");

                Author author = new Author();

                if(name.equals(rowAuthorSpecific[0].trim()))
                {
                    author.setName(rowAuthorSpecific[0]);
                   // System.out.println(author.getName() + "get got");
                    author.setBio(rowAuthorSpecific[1]);
                }

                authorMap.put(name + key, author);
                key++;






            }
        }
        catch(FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }
}
