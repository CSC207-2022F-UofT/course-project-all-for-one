public class Browsing {
    private String productName;
    private Browsing currentVisit;
    private Browsing previousVisit;
    private Browsing nextVisit;

    public static void main(String[] args) {
        Post post= new Post();
        post.get_title();
        post.get_description;
        post.get_status;
        post.get_price();
        post.get_tag;
    }
    public Browsing(String product, Browsing pre, Browsing curr, Browsing next) {
        productName = product;
        previousVisit = pre;
        currentVisit = curr;
        nextVisit = next;
    }

   public Browsing getPreviousVisit() {

        return previousVisit;
   }

   public Browsing getNextVisit() {
        return nextVist;
   }

   public void setNextVisit(Browsing newVisit) {
        nextVisit = newVisit;
   }


   public String getBrowsedProduct() {
       return this.productName
   }

    private void BrowsingHistory() {
        Browsing now = currentVisit;
        int counter = 0;
        while (now != null) {
            System.out.println(now);
            now = now.getPreviousVisit();
            counter++;
        }
        System.out.println();
    }

    public Browsing

}
