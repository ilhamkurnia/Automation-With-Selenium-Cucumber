Feature: User Memasukkan ke Keranjang

  Scenario: Testing Memasukkan Barang ke Keranjang
    When User memasukkan ke keranjang
    Then User berhasil memasukkan ke keranjang

  Scenario: Testing Checkout Dengan First Name Kosong
    When User memasukkan first name kosong
    Then User gagal checkout dengan first name kosong

  Scenario: Testing Checkout Dengan Last Name Kosong
    When User memasukkan last name kosong
    Then User gagal checkout dengan last name kosong

  Scenario: Testing Checkout Dengan Postal Code Kosong
    When User memasukkan postal code kosong
    Then User gagal checkout dengan postal code kosong

  Scenario: Testing Checkout Dengan Informasi Lengkap
    When User memasukkan informasi dengan lengkap
    Then User berhasil checkout
