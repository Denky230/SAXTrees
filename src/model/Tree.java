
package model;

public class Tree {

    private String codi;
    private String posX;
    private String posY;
    private String latitude;
    private String longitud;
    private String elementType;
    private String greenSpace;
    private String direction;
    private String height;
    private String specieCategoryID;
    private String cientificName;
    private String nameES;
    private String nameCAT;
    private String treeCategory;
    private String voreraWidth;
    private String plantacioDT;
    private String waterType;
    private String tipReg;
    private String surfaceType;
    private String supportType;
    private String treeHoleCover;
    private String treeHoleSize;
    private String treeHoleVora;

    public Tree(String codi, String posX, String posY, String latitude, String longitud, String elementType, String greenSpace, String direction, String height, String specieCategoryID, String cientificName, String nameES, String nameCAT, String treeCategory, String voreraWidth, String plantacioDT, String waterType, String tipReg, String surfaceType, String supportType, String treeHoleCover, String treeHoleSize, String treeHoleVora) {
        this.codi = codi;
        this.posX = posX;
        this.posY = posY;
        this.latitude = latitude;
        this.longitud = longitud;
        this.elementType = elementType;
        this.greenSpace = greenSpace;
        this.direction = direction;
        this.height = height;
        this.specieCategoryID = specieCategoryID;
        this.cientificName = cientificName;
        this.nameES = nameES;
        this.nameCAT = nameCAT;
        this.treeCategory = treeCategory;
        this.voreraWidth = voreraWidth;
        this.plantacioDT = plantacioDT;
        this.waterType = waterType;
        this.tipReg = tipReg;
        this.surfaceType = surfaceType;
        this.supportType = supportType;
        this.treeHoleCover = treeHoleCover;
        this.treeHoleSize = treeHoleSize;
        this.treeHoleVora = treeHoleVora;
    }
}