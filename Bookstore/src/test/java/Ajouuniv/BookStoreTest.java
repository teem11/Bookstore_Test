package Ajouuniv;

import org.junit.Test;
import sun.invoke.empty.Empty;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookStoreTest {
    BookStore bookTest = new BookStore();
    @Test
    public void emptyTest_맨처음객체의_list가_비어있는상태인지테스트(){
        BookStore emptyList = new BookStore();
        assertThat(emptyList.bookList.isEmpty(),is(true));
    }
    @Test
    public void notNullCheck_booklist추가후널값이아닌지를테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList,notNullValue());
    }
    @Test
    public void loanedTest_맨처음등록했을때반납상태인지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList.get(0).loaned,is(false));
    }
    @Test
    public void titleTest_올바른제목이들어갔는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList.get(0).getTitle(), is("너의췌장을먹고싶어"));
    }
    @Test
    public void authorTest_올바른작가가들어갔는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList.get(0).getAuthor(),is("스미노 요루"));
    }
    @Test
    public void subjectTest_올바른분야가들어갔는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList.get(0).getSubject(),is("소설"));
    }
    @Test
    public void delByTitleTest_제목으로삭제가잘되는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList.isEmpty(), is(false));
        bookTest.delBookBytitle("너의췌장을먹고싶어");
        assertThat(bookTest.bookList.isEmpty(), is(true));
    }
    @Test
    public void delByBooknumTest_책번호로삭제가잘되는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList.isEmpty(), is(false));
        bookTest.delBookByNumber(1);
        assertThat(bookTest.bookList.isEmpty(), is(true));
    }
    @Test
    public void sizeTest_책을등록하고객체의크기를테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        bookTest.addBook("유성의 인연","히가시노 게이고","소설",2);
        bookTest.addBook("해리포터와 불의잔","조앤 롤링","소설",3);
        assertThat(bookTest.bookList.size(), is(3));
    }
    @Test
    public void containTest_등록한책의제목에포함되는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        assertThat(bookTest.bookList.get(0).getTitle(),containsString("췌장"));
    }
    @Test
    public void loanTest_책이정상적으로빌려지는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        bookTest.loanBook("너의췌장을먹고싶어");
        assertThat(bookTest.bookList.get(0).loaned,is(true));
    }
    @Test
    public void returnTest_책이정상적으로반납되는지테스트(){
        bookTest.addBook("너의췌장을먹고싶어","스미노 요루","소설",1);
        bookTest.loanBook("너의췌장을먹고싶어");
        bookTest.returnBook("너의췌장을먹고싶어");
        assertThat(bookTest.bookList.get(0).loaned,is(false));
    }
}
