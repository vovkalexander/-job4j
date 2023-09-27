package ru.job4j.nonblocking;
import java.util.concurrent.ConcurrentHashMap;
/**
 * CacheNonBlock.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class CacheNonBlock {
  /**
   * Field - stores object of ConcurrentHashMap.
   */
  private final   ConcurrentHashMap<Integer, Base> bases = new ConcurrentHashMap<>();
  /**
   * The method adds object into  collection.
   */

  public void add(Base model) {
    bases.putIfAbsent(model.getId(), model);
  }
  /**
   * The method updates object into collection as provide as
   * version of old value and new value are inconsistent otherwise
   * throwing exception.
   */

  public void update(Base model) {
    bases.computeIfPresent(model.getId(), (key, value) -> {
      if (model.getVersion() != value.getVersion()) {
        throw new OptimisticException("The versions are inconsistent");
      }
      value.setVersion(value.getVersion() + 1);
      return value;
    });

  }
  /**
   * The method removes  object from collection by id of object.
   */

  public void delete(Base model) {
    bases.remove(model.getId());
  }
}
