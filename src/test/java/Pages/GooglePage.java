package Pages;

public class GooglePage extends BasePage{

    public GooglePage(){
        super(driver);
    }

    private String searchButton = "(//input[@value='Buscar con Google'])";
    private String textSearchField = "//textarea[@type='search']";

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }
    public void searchCriteria(String text){write(textSearchField,text);}
    public void clickSearchButton(){clickElement(searchButton);}
}
