package celline.lista08.figuras.controller;

import celline.lista08.figuras.model.Retangulo;

public class OperacaoRetangulo implements IGeometriaController<Retangulo> {

    @Override
    public float Area(Retangulo r) {
        return r.getAltura() * r.getBase();
    }

    @Override
    public float Perimetro(Retangulo r) {
        return 2 * (r.getBase() + r.getAltura());
    }
}
