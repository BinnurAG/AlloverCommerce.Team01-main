
package team01_AlloverCommerceTestNG.pages;

import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class Pages {

    public static ReusableMethods registerButton;
    private P1_HomePage homePage;
    private P2_RegisterPage registerPage;
    private P3_UserVendorLoginPage userVendorLoginPage;
    private P4_MyAccountPage myAccountPage;
    private P5_AddressesPage addressesPage;
    private P6_AccountDetails accountDetails;
    private P7_ShoppingPage shoppingPage;
    private P8_ProductPage productPage;
    private P9_CartPage cartPage;
    private P10_CheckOutPage checkOutPage;
    private P11_OrderComplatePage orderComplatePage;
    private P12_ComparePage comparePage;
    private P13_WishlistPage wishlistPage;
    private P14_VendorRegisterPage vendorRegisterPage;
    private P15_VendorAddressesPage vendorAddressesPage;
    private P16_VendorStoreManagerPage vendorStoreManagerPage;
    private P17_VendorProductDashboardPage vendorProductDashboardPage;
    private P18_VendorProductManagerPage vendorProductManagerPage;
    private P19_OrderPage orderPage;
    private P20_VendorCouponsPage vendorCouponsPage;
    public Pages() {
    }

    public P1_HomePage homePage() {
        if (homePage == null) {
            homePage = new P1_HomePage();
        }
        return homePage;
    }

    public P2_RegisterPage registerPage() {
        if (registerPage == null) {
            registerPage = new P2_RegisterPage();
        }

        return registerPage;
    }

    public P3_UserVendorLoginPage userVendorLoginPage() {
        if (userVendorLoginPage == null) {
            userVendorLoginPage = new P3_UserVendorLoginPage();
        }
        return userVendorLoginPage;
    }

    public P4_MyAccountPage myAccountPage() {
        if (myAccountPage == null) {
            myAccountPage = new P4_MyAccountPage();
        }
        return myAccountPage;
    }

    public P5_AddressesPage addressesPage() {
        if (addressesPage == null) {
            addressesPage = new P5_AddressesPage();
        }
        return addressesPage;
    }

    public P6_AccountDetails accountDetails() {
        if (accountDetails == null) {
            accountDetails = new P6_AccountDetails();
        }
        return accountDetails;
    }

    public P7_ShoppingPage shoppingPage() {
        if (shoppingPage == null) {
            shoppingPage = new P7_ShoppingPage();
        }
        return shoppingPage;
    }

    public P8_ProductPage productPage() {
        if (productPage == null) {
            productPage = new P8_ProductPage();
        }
        return productPage;
    }

    public P9_CartPage cartPage() {
        if (cartPage == null) {
            cartPage = new P9_CartPage();
        }
        return cartPage;
    }

    public P10_CheckOutPage checkOutPage() {
        if (checkOutPage == null) {
            checkOutPage = new P10_CheckOutPage();
        }
        return checkOutPage;
    }

    public P11_OrderComplatePage orderComplatePage() {
        if (orderComplatePage == null) {
            orderComplatePage = new P11_OrderComplatePage();
        }
        return orderComplatePage;
    }

    public P12_ComparePage comparePage() {
        if (comparePage == null) {
            comparePage = new P12_ComparePage();
        }
        return comparePage;

    }

    public P13_WishlistPage wishlistPage() {
        if (wishlistPage == null) {
            wishlistPage = new P13_WishlistPage();
        }
        return wishlistPage;
    }

    public P14_VendorRegisterPage vendorRegisterPage() {
        if (vendorRegisterPage == null) {
            vendorRegisterPage = new P14_VendorRegisterPage();
        }
        return vendorRegisterPage;
    }

    public P15_VendorAddressesPage vendorAddressesPage() {
        if (vendorAddressesPage == null) {
            vendorAddressesPage = new P15_VendorAddressesPage();
        }
        return vendorAddressesPage;
    }

    public P16_VendorStoreManagerPage vendorStoreManagerPage() {
        if (vendorStoreManagerPage == null) {
            vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        }
        return vendorStoreManagerPage;
    }

    public P17_VendorProductDashboardPage vendorProductDashboardPage() {
        if (vendorProductDashboardPage == null) {
            vendorProductDashboardPage = new P17_VendorProductDashboardPage();
        }
        return vendorProductDashboardPage;
    }

    public P18_VendorProductManagerPage vendorProductManagerPage() {
        if (vendorProductManagerPage == null) {
            vendorProductManagerPage = new P18_VendorProductManagerPage();
        }
        return vendorProductManagerPage;
    }

    public P19_OrderPage orderPage() {
        if (orderPage == null) {
            orderPage = new P19_OrderPage();
        }
        return orderPage;
    }

    public P20_VendorCouponsPage vendorCouponsPage() {
        if (vendorCouponsPage == null) {
            vendorCouponsPage = new P20_VendorCouponsPage();
        }
        return vendorCouponsPage;
    }

}
