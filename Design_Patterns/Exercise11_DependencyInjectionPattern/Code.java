interface CustomerDataSource {
    String findCustomerById(int id);
}
class CustomerDataSourceImpl implements CustomerDataSource {
    public String findCustomerById(int id) {
        if (id == 101) {
            return "Customer ID: 101, Name: mathu, Status: Active";
        } else {
            return "Customer with ID " + id + " not found.";
        }
    }
}
class CustomerService {
    private CustomerDataSource dataSource;
    
    public CustomerService(CustomerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void getCustomerDetails(int customerId) {
        String result = dataSource.findCustomerById(customerId);
        System.out.println(result);
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Customer Management");

        CustomerDataSource repo = new CustomerDataSourceImpl();
        CustomerService service = new CustomerService(repo);

        service.getCustomerDetails(202);
        service.getCustomerDetails(979);
    }
}
