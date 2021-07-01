package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;
import be.intecbrussel.exceptions.NoMoreIceCreamException;

// interface for all ice cream selling businesses
public interface IceCreamSeller extends Profitable{
    Cone orderCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException;
    IceRocket orderIceRocket() throws NoMoreIceCreamException;
    Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException;
}
