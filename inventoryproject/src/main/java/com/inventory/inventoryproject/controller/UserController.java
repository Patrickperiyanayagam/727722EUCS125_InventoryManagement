package com.inventory.inventoryproject.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventoryproject.model.BarCode;
import com.inventory.inventoryproject.model.Bill;
// import com.inventory.inventoryproject.model.FetchPage;
import com.inventory.inventoryproject.model.Product;
import com.inventory.inventoryproject.model.Supplier;
import com.inventory.inventoryproject.model.UserModel;
import com.inventory.inventoryproject.repository.ProductRepository;
import com.inventory.inventoryproject.repository.UserRepository;
import com.inventory.inventoryproject.service.BarCodeService;
import com.inventory.inventoryproject.service.BillService;
// import com.inventory.inventoryproject.service.FetchPageService;
import com.inventory.inventoryproject.service.ProductService;
import com.inventory.inventoryproject.service.SupplierService;
import com.inventory.inventoryproject.service.UserService;


















@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BillService billService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private BarCodeService barCodeService;

    // @Autowired
    // private FetchPageService fetchPageService;
    
    private ProductService productService;
    public UserController(ProductService productService)
    {
        this.productService=productService;
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/inventory/user/postUser")
    public String postMethodName(@RequestBody UserModel usermodel) {
        userService.userSave(usermodel);
        return "Saved in DB";
    }
    @ResponseStatus(value = HttpStatus.FOUND)
    @GetMapping("/inventory/user/getUser/{name}/{password}")
    public List<UserModel> getMethodName(@PathVariable("name") String name,@PathVariable("password") String password) {
        return userRepository.findByUsernameAndPassword(name, password);
    }
    

    //  -------------------------- USER ------------------------------------------
    @PostMapping("/inventory/product/post")
    public Product postMethodName(@RequestBody Product product) {
        
        return productService.savProduct(product);
    }

    @GetMapping("/inventory/product/{id}")
    public Product getMethodName(@PathVariable("id") int a)
    {
        return productService.getProductID(a);
    }

    @GetMapping("/inventory/product/check/{name}")
    public List<Product> getStringName(@PathVariable("name") String name)

    {
        return productRepository.findByProductName(name);
    }

    @PutMapping("/inventory/product/update/{id}")
    public ResponseEntity<String> putMethodName(@RequestBody Product updateProduct,@PathVariable int id)
    {
        Product exisProduct=productService.getProductID(id);
        if(exisProduct!=null)
        {
            exisProduct.setQuantity(updateProduct.getQuantity());

            exisProduct.setAvailableStatus(updateProduct.getAvailableStatus());
            exisProduct.setPrice(updateProduct.getPrice());
            productService.savProduct(exisProduct);

        }
        else
        {
            return new ResponseEntity<>("data not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("updated",HttpStatus.ACCEPTED);
        
    }

    @DeleteMapping("/inventory/product/{id}")
    public String deleteMethodName(@PathVariable("id") int a)
    {
        Product exiProduct=productService.getProductID(a);
        if(exiProduct!=null)
        {
            productService.deleteProduct(a);
            return "deleted";
        }
        else
        {
            return "data not found";
        }
    }

    @GetMapping("/inventory/product/filter/{price}")
    public List<Product> getMethodByName(@PathVariable("price") double price)
    {
        return productService.getProductByPrice(price);
    }

    @GetMapping("/inventory/product/getallproduct")
    public List<Product> getallpro() {
        return productService.getall();
    }
    
    

    //  ----------------------PRODUCT ---------------------------------

    @PostMapping("/inventory/bill/post")
    public Bill postMethodName(@RequestBody Bill order) {
        
        LocalDate date=LocalDate.now();
        String d=date+"";
        order.setOrderDate(d);
        return billService.savProduct(order);
    }
    @GetMapping("/inventory/bill/getallbills")
    public List<Bill> getallbill() {
        return billService.getallbill();
    }
    
    @GetMapping("/inventory/bill/{id}")
    public Bill getMethodNameByIOrder(@PathVariable("id") int a)
    {
        return billService.getOrder(a);
    }

    // @PutMapping("inventory/buyproduct/{id}/{quantity}")
    // public String putMethodName(@PathVariable("id") int id, @PathVariable("quantity") int quantity) {
        
    //     Product existProduct = productService.getProductID(id);
    //     if(existProduct != null && existProduct.getQuantity() > quantity){
    //         Bill bill=new Bill();
    //         LocalDate date=LocalDate.now();
    //         String d=date+"";
    //         bill.setQuanOrdered(quantity);
    //         bill.setProductOrdered(existProduct.getProductName());
    //         bill.setOrderDate(d);
    //         bill.setTotalPrice(quantity * existProduct.getPrice());
    //         billService.savProduct(bill);

    //         existProduct.setQuantity(existProduct.getQuantity() - quantity);
    //         productService.savProduct(existProduct);
    //     }
    //     else{
    //         return "No data or insufficient amount of quqntity";
    //     }
    //     return "The items are fetched";
    // }

    @GetMapping("/inventory/totalbill")
    public double getMethodName() {
        return billService.totalbill();
    }
    
    @GetMapping("/inventory/user/endswith/{value}")
    public List<UserModel> getemailendswith(@PathVariable("value") String value) {
        return userRepository.findByUseremailEndingWith(value);
    }
 
    //  -------------------BILL--------------------------------------

    @GetMapping("/inventory/product/getpage/{pageno}/{size}")
    public Page<Product> getpage(@PathVariable("pageno") int pageno,@PathVariable("size") int size) {
        return productService.getPage(pageno, size);
    }
    @GetMapping("/inventory/product/getpagecontent/{pageno}/{size}")
    public List<Product> getpagecontent(@PathVariable("pageno") int pageno,@PathVariable("size") int size) {
        return productService.getpagecontent(pageno, size);
    }
    
    @GetMapping("/inventory/product/getpage/sorted/{pageno}/{size}/{name}")
    public Page<Product> getpagesorted(@PathVariable("pageno") int pageno,@PathVariable("size") int size,@PathVariable("name") String name) {
        return productService.getpagesorted(pageno, size, name);
    }
    
    @GetMapping("/inventory/product/getprice/{val1}/{val2}")
    public List<Product> getMethodName(@PathVariable("val1") int value1,@PathVariable("val2") int value2) {
        return productRepository.findByPriceBetween(value1, value2);
    }

    // @GetMapping("/inventory/getprice/fetch/{val1}/{val2}/{val3}/{val4}")
    // public Page<FetchPage> getPageFetch(@PathVariable("val1") int value1,@PathVariable("val2") int value2,@PathVariable("val3") int value3,@PathVariable("val4") int value4) {
    //     List<Product> pro = productRepository.findByPriceBetween(value1, value2);
    //     List<FetchPage> fet = new ArrayList<>();
    //     for(Product p : pro){
    //         FetchPage temp = new FetchPage();
    //         temp.setProductId(p.getProductId());
    //         temp.setPrice(p.getPrice());
    //         temp.setCategory(p.getCategory());
    //         temp.setQuantity(p.getQuantity());
    //         temp.setAvailableStatus(p.getAvailableStatus());
    //         temp.setProductName(p.getProductName());
    //         fet.add(temp);
    //     }
    //     fetchPageService.postpage(fet);
    //     Page<FetchPage> ans = fetchPageService.getpage(value3, value4);
    //     // productService.deleteTotal();
    //     return ans;
    // }
    
    @GetMapping("/inventory/product/getprice/getbypage/{val1}/{val2}/{val3}/{val4}")
    public Page<Product> getpagevalue(@PathVariable("val1") int value1,@PathVariable("val2") int value2,@PathVariable("val3") int value3,@PathVariable("val4") int value4) {
        PageRequest pg = PageRequest.of(value3, value4);
        return productService.getPageBetweenPrice(value1, value2, pg);
    }
    
// ---------------------------PAGINATION-----------------------------------------

    @PostMapping("/inventory/supplier/post")
    public Supplier postsupplier(@RequestBody Supplier supplier) {
        
        return supplierService.postsupplier(supplier);
    }
    
    @GetMapping("/inventory/supplier/getallsupplier")
    public List<Supplier> getallsupplier() {
        return supplierService.getallsupplier();
    }

    @GetMapping("/inventory/supplier/getsupplier/{id}")
    public Supplier getsupplier(@PathVariable("id") int id) {
        return supplierService.getsupplier(id);
    }

    // -----------------------------SUPPLIER---------------------------------

    @PostMapping("/inventory/barcode/post")
    public BarCode postbarcode(@RequestBody BarCode barCode) {
        return barCodeService.savebar(barCode);
    }
    
    @GetMapping("/inventory/barcode/getall")
    public List<BarCode> getallbarcode() {
        return barCodeService.getallbarcode();
    }

    // -------------------------BARCODE-----------------------------------
    
}
