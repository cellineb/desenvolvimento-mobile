package celline.lista08.figuras.controller;

import celline.lista08.figuras.model.Circulo;

public class OperacaoCirculo implements IGeometriaController<Circulo>{
    @Override
    public float Area(Circulo c) {
        return (float) (3.14 * (Math.pow(c.getRaio(), 2)));
    }

    @Override
    public float Perimetro(Circulo c) {
        return (float) (2 * 3.14 * c.getRaio());
    }
}
