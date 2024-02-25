import java.util.ArrayList;
import java.util.List;
import java.util.Date;

// NAMA: Mochammad Rakandiya S G
// NIM: 2203956
// Kelas: RPl-4B

class Book {
    protected String title;
    protected String author;
    protected int year;

    // Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getInfo() {
        return "Judul: " + title + ", Penulis: " + author + ", Tahun Terbit: " + year;
    }
}

class Library {
    protected List<Book> books = new ArrayList<>(); // Inisialisasi di tempat deklarasi variabel

    // Method untuk menambahkan buku ke perpustakaan
    public void addBook(Book book) {
        books.add(book);
    }

    // Method untuk menghapus buku dari perpustakaan
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method untuk menampilkan seluruh koleksi buku dalam perpustakaan
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Perpustakaan kosong.");
        } else {
            System.out.println("Koleksi buku dalam perpustakaan:");
            for (Book book : books) {
                System.out.println(book.getInfo());
            }
        }
    }
}

class Peminjaman {
    private String bookTitle;
    private String borrower;
    private Date borrowDate;
    private Date returnDate;

    // Constructor
    public Peminjaman(String book, String borrower, Date borrowDate, Date returnDate) {
        this.bookTitle = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.returnDate = tambahHari(borrowDate, 7);
    }

    public void displayPeminjamanInfo() {
        System.out.println("Peminjaman:");
        System.out.println("Judul: " + bookTitle);
        System.out.println("Nama Peminjam: " + borrower);
        System.out.println("Tanggal Peminjaman: " + borrowDate);
        System.out.println("Tanggal Pengembalian: " + returnDate);
    }

    // Method untuk menambahkan hari ke tanggal
    private Date tambahHari(Date tanggal, int jumlahHari) {
        long tglMillis = tanggal.getTime(); // Konversi ke milidetik
        long tambahanMillis = jumlahHari * 24 * 60 * 60 * 1000L; // Hitung tambahan milidetik untuk jumlah hari
        return new Date(tglMillis + tambahanMillis); // Tambahkan tambahan milidetik ke tanggal asli dan kembalikan sebagai objek Date baru
    }
}

public class App {
    public static void main(String[] args) {
        // Membuat objek perpustakaan
        Library library = new Library();

        // Menambahkan beberapa buku ke perpustakaan
        Book book1 = new Book("Java Programming", "John Doe", 2020);
        Book book2 = new Book("Python Basics", "Jane Smith", 2019);
        Book book3 = new Book("Data Structures", "David Johnson", 2021);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Menampilkan koleksi buku dalam perpustakaan
        library.displayBooks();
        System.out.println("\n");

        // Menambahkan peminjaman
        Peminjaman peminjaman1 = new Peminjaman(book1.title, "Alice", new Date(), new Date());


        // Menampilkan peminjaman
        peminjaman1.displayPeminjamanInfo();

        // Menghapus sebuah buku dari perpustakaan
        library.removeBook(book2);

        // Menampilkan kembali koleksi buku dalam perpustakaan setelah buku dihapus

        System.out.println("\nKoleksi buku setelah buku dihapus:\n");
        library.displayBooks();
    }
}
