package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public interface IceCreamSeller extends Profitable{
    Cone orderCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException;
    IceRocket orderIceRocket() throws NoMoreIceCreamException;
    Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException;
}
