
package model;

public class Tree {

    private String code;
    private Double posX;
    private Double posY;
    private Double latitude;
    private Double longitude;
    private String elementType;
    private String greenSpace;
    private String direction;
    private String height;
    private int specieCategoryID;
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

    public String getCode() {
        return code;
    }

    public Double getPosX() {
        return posX;
    }

    public Double getPosY() {
        return posY;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getElementType() {
        return elementType;
    }

    public String getGreenSpace() {
        return greenSpace;
    }

    public String getDirection() {
        return direction;
    }

    public String getHeight() {
        return height;
    }

    public int getSpecieCategoryID() {
        return specieCategoryID;
    }

    public String getCientificName() {
        return cientificName;
    }

    public String getNameES() {
        return nameES;
    }

    public String getNameCAT() {
        return nameCAT;
    }

    public String getTreeCategory() {
        return treeCategory;
    }

    public String getVoreraWidth() {
        return voreraWidth;
    }

    public String getPlantacioDT() {
        return plantacioDT;
    }

    public String getWaterType() {
        return waterType;
    }

    public String getTipReg() {
        return tipReg;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public String getSupportType() {
        return supportType;
    }

    public String getTreeHoleCover() {
        return treeHoleCover;
    }

    public String getTreeHoleSize() {
        return treeHoleSize;
    }

    public String getTreeHoleVora() {
        return treeHoleVora;
    }


    
    public void setCode(String code) { this.code = code; }
    public void setPosX(Double posX) { this.posX = posX; }
    public void setPosY(Double posY) { this.posY = posY; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public void setElementType(String elementType) { this.elementType = elementType; }
    public void setGreenSpace(String greenSpace) { this.greenSpace = greenSpace; }
    public void setDirection(String direction) { this.direction = direction; }
    public void setHeight(String height) { this.height = height; }
    public void setSpecieCategoryID(int specieCategoryID) { this.specieCategoryID = specieCategoryID; }
    public void setCientificName(String cientificName) { this.cientificName = cientificName; }
    public void setNameES(String nameES) { this.nameES = nameES; }
    public void setNameCAT(String nameCAT) { this.nameCAT = nameCAT; }
    public void setTreeCategory(String treeCategory) { this.treeCategory = treeCategory; }
    public void setVoreraWidth(String voreraWidth) { this.voreraWidth = voreraWidth; }
    public void setPlantacioDT(String plantacioDT) { this.plantacioDT = plantacioDT; }
    public void setWaterType(String waterType) { this.waterType = waterType; }
    public void setTipReg(String tipReg) { this.tipReg = tipReg; }
    public void setSurfaceType(String surfaceType) { this.surfaceType = surfaceType; }
    public void setSupportType(String supportType) { this.supportType = supportType; }
    public void setTreeHoleCover(String treeHoleCover) { this.treeHoleCover = treeHoleCover; }
    public void setTreeHoleSize(String treeHoleSize) { this.treeHoleSize = treeHoleSize; }
    public void setTreeHoleVora(String treeHoleVora) { this.treeHoleVora = treeHoleVora; }

    @Override
    public String toString() {
        return code + " - " + posX + " - " + posY + " - " + latitude + " - " + longitude + " - " + elementType + " - " + greenSpace + " - " + direction + " - " + height + " - " + specieCategoryID + " - " + cientificName + " - " + nameES + " - " + nameCAT + " - " + treeCategory + " - " + voreraWidth + " - " + plantacioDT + " - " + waterType + " - " + tipReg + " - " + surfaceType + " - " + supportType + " - " + treeHoleCover + " - " + treeHoleSize + " - " + treeHoleVora;
    }
}