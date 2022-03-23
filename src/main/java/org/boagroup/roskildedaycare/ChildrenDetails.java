package org.boagroup.roskildedaycare;

import javafx.beans.property.StringProperty;

import java.util.Date;

public class ChildrenDetails {

        private int childrenId;
        private String firstName;
        private String lastName;
        private int groupID;
        private Date birthDate;

        public ChildrenDetails(int childrenId, String firstName, String lastName, int groupID, Date birthDate) {
                this.childrenId = childrenId;
                this.firstName = firstName;
                this.lastName = lastName;
                this.groupID = groupID;
                this.birthDate = birthDate;
        }


        public int getChildrenId() {
                return childrenId;
        }

        public void setChildrenId(int childrenId) {
                this.childrenId = childrenId;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public int getGroupId() {
                return groupID;
        }

        public void setGroupID(int groupName) {
                this.groupID = groupName;
        }

        public Date getBirthDate() {
                return birthDate;
        }

        public void setBirthDate(Date birthDate) {
                this.birthDate = birthDate;
        }
}



