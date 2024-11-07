package celline.lista08.figuras.controller;

import celline.lista08.figuras.model.Retangulo;

public interface IGeometriaController<T> {


    public float Area(T t);
    public float Perimetro(T t);

}
