import React from 'react';
import {Table,Glyphicon} from 'react-bootstrap';

class AddForm extends React.Component {

    constructor() {
            super();
            this.switchColor.bind(this);
    }

    switchColor(priority){
        var priorityColor = "alert alert-warning";

        switch(priority) {
               case 'HIGH':
                    priorityColor = "alert alert-danger";
                    break;

               case 'LOW':
                    priorityColor = "alert alert-success";
                    break;

               default:
               break;
        }

        return priorityColor;
    }

   render() {
    return (
      <div>
        <Table>
              <thead>
                  <tr>
                       <th>Task name</th><th> </th><th>ID</th><th>Priority</th>
                  </tr>
              </thead>
              <tbody>
                   {
                        this.props.tasks.map( (t,i) =>
                            <tr className={this.switchColor(t.priority)}>
                                 <td >{t.name}</td><td> </td>
                                 <td>{t.id}</td>
                                 <td>
                                      <span>{t.priority}</span>
                                      <span className="pull-right" ><Glyphicon glyph="glyphicon glyphicon-remove" onClick={() => this.props.onDelete(t.id)} /></span>
                                 </td>
                            </tr>
                        )
                   }
              </tbody>
        </Table>
      </div>
    );
  }
}

export default AddForm;