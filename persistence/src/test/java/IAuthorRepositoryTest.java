import model.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.AuthorRepository;
import repository.IAuthorRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;

public class IAuthorRepositoryTest {

 /*   private IAuthorRepository iAuthorRepository;

    @Before
    public void init() {
        iAuthorRepository = AuthorRepository.getInstance();
    }

    @Test
    public void shouldReturnFirstAuthor(){
        //given


        //when
        Author result = iAuthorRepository.getAuthorById(1L);

        //then
        Assert.assertEquals(result.getFirstName(),"Jan");
        Assert.assertEquals(result.getLastName(),"Brzechwa");
    }

    @Test
    public void shouldReturnNumbersOfAuthors() {
        //given

        //when
        int result = iAuthorRepository.getAllAuthors().size();

        //then
        Assert.assertEquals(result,4);
    }

    @Test
    public void shouldSaveAuthor() {
        //given
        Author author = new Author();
        author.setFirstName("Herbert");
        author.setLastName("Shildt");

        //when
        iAuthorRepository.save(author);

        //then
        Assert.assertEquals(iAuthorRepository.getAllAuthors().size(),5);
        iAuthorRepository.delete(author);
    }

    @Test
    public void shouldEditAuthor() {
        //given
        Author author = iAuthorRepository.getAuthorById(4L);
        author.setFirstName("Adam");

        //when
        iAuthorRepository.edit(author);

        //then
        Assert.assertEquals(iAuthorRepository.getAuthorById(4L).getFirstName(),"Adam");
    }

    @Test
    public void shouldDeleteAuthor() {
        //given
        Author author = iAuthorRepository.getAuthorById(6L);

        //when
        iAuthorRepository.delete(author);

        //then
        Assert.assertNull(iAuthorRepository.getAuthorById(6L));
    }

*/

}
