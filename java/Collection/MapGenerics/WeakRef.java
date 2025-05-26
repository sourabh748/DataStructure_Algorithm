package Collection.MapGenerics;

// import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

class Phone {
    String brand;
    String Model;

    
    public Phone(String brand, String model) {
        this.brand = brand;
        Model = model;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((Model == null) ? 0 : Model.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Phone other = (Phone) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (Model == null) {
            if (other.Model != null)
                return false;
        } else if (!Model.equals(other.Model))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Phone [brand=" + brand + ", Model=" + Model + "]";
    }

}

public class WeakRef {
    public static void main(String[] args) throws InterruptedException {

        // WeakReference<Phone> phoneWeakRefrence = new WeakReference<>(new Phone("Apple", "16 Pro Max"));
        // System.out.println(phoneWeakRefrence.get());
        // System.gc();
        // try {
        //     Thread.sleep(10000);
        // } catch (Exception ignored) {
        // }

        // System.out.println(phoneWeakRefrence.get());

        WeakHashMap<String, Phone> lruCache = new WeakHashMap<>();
        loadCache(lruCache);
        System.out.println(lruCache);
        System.gc();

        Thread.sleep(10000);

        System.out.println(lruCache);

    }

    private static void loadCache(Map<String, Phone> lruCacheWeakHashMap) {
        lruCacheWeakHashMap.put(new String("Sourabh suman"), new Phone("Apple", "16 pro Max"));
        lruCacheWeakHashMap.put(new String("Gourav Kumar"), new Phone("Xiaomi", "Redmi Note 10 Pro"));
    }
}
