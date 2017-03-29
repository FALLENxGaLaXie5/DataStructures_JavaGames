
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Joshua Steward
 * @version 3/31/2015
 */
public class Set<K extends Comparable<? super K>> implements SetInterface<K>, Iterable<K>
{
   private HashMap<K, Boolean> items;
     
   public Set()
   {
      this.items = new HashMap<>();
   } // end default constructor


   /**
    * sets flag to false
    * sets result to the added items entry
    * if result is not null
    *    sets flag to true
    * @param newEntry  the object to be added as a new entry
    * @return
    */
   public boolean add(K newEntry)
   {
         boolean flag = false;
         Boolean result = this.items.put(newEntry, true);
         if (result != null)
         {
            flag = true;
         }
      return flag;
   } // end add


   /**
    * sets flag to false
    * if the items get entry is not null
    *    removes entry
    *    sets flag to true
    * @param anEntry  the object to be removed
    * @return
    */
   public boolean remove(K anEntry)
   {
      boolean flag = false;
      if (this.items.get(anEntry) != null)
      {
         this.items.remove(anEntry);
         flag = true;
      }
      return flag;
   } // end remove


   /**
    * calls clear
    */
   public void clear()
   {
      this.items.clear();
   } // end clear


   /**
    * calls contains; sets flag to false and nulls out
    * @param anEntry  the object that is the desired entry
    * @return
    */
   public boolean contains(K anEntry)
   {
      boolean flag = false;
      if (this.items.get(anEntry) != null)
      {
         flag = true;
      }
      return flag;
   } // end contains

   public int getCurrentSize()
   {
      return this.items.size();
   } // end getCurrentSize
   
   public boolean isEmpty()
   {
      return this.items.isEmpty();
   } // end isEmpty

   public Iterator<K> getIterator()
   {
      return iterator();
   } // end getIterator

   public Iterator<K> iterator()
   {
      return this.items.keySet().iterator();
   } // end iterator


   /**
    * uses iterator to iterate through
    * @return
    */
   public K[] toArray()
   {
      @SuppressWarnings("unchecked")
      K[] newArray = (K[]) new Comparable<?>[this.items.size()];
      Iterator<K> iter = this.iterator();
      int i = 0;
      while (iter.hasNext())
      {
         K abc = iter.next();
         newArray[i] = abc;
         i++;
      }
      return newArray;
   } // end toArray

   public SetInterface<K> union(SetInterface<K> otherSet)
   {
      Set<K> other = (Set<K>) otherSet;
      Set<K> unionSet = new Set<>();
      Iterator<K> iterThis = this.iterator();
      Iterator<K> iterOther = other.iterator();
      while (iterThis.hasNext())
      {
         unionSet.add(iterThis.next());
      }
      while (iterOther.hasNext())
      {
         unionSet.add(iterOther.next());
      }
      return unionSet;
   } // end union


   /**
    * finds intersection of two sets
    * @param otherSet
    * @return
    */
   public SetInterface<K> intersection(SetInterface<K> otherSet)
   {
      Set<K> other = (Set<K>) otherSet;
      Set<K> intersectionSet = new Set<>();
      Set<K> copyOfOtherBag = new Set<>();
      Iterator<K> iterOther = other.iterator();
      while (iterOther.hasNext())
      {
         copyOfOtherBag.add(iterOther.next());
      }
      Iterator<K> iterThis = this.iterator();
      while (iterThis.hasNext())
      {
         K currentObject = iterThis.next();
         if (copyOfOtherBag.items.get(currentObject) != null)
         {
            intersectionSet.add(currentObject);
            copyOfOtherBag.remove(currentObject);
         }
      }
      return intersectionSet;
   } // end intersection
} // end Set