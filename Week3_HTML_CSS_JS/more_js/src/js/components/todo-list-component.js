import Component from './component';
import TodoComponent from './todo-component';

class TodoListComponent extends Component {
    constructor(todolist) {
        super();
        this._todolist = todolist || {}

        this._elem = document.createElement('div');
        this._elem.classList.add('todo-list');
    }

    render() {
        this._elem.innerText = "";

        this._todolist.todos.forEach(todo => {
            const todoComp = new TodoComponent(todo).render();
            this._elem.appendChild(todoComp);
        });

        return this._elem;
    }
}

export default TodoListComponent;