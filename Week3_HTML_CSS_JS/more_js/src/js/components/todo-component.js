import Component from './component';

class TodoComponent extends Component{
    // make sure to call super in subclass constructor
    constructor(todo) {
        super();
        this._todo = todo || {};
        this._elem = document.createElement('div');
        this._elem.classList.add('todo-item');
    }

    render() {
        this._elem.innerText = "";
        const span = document.createElement('span');
        span.innerText = this._todo.name;
        span.onclick = this.onClick.bind(this);
        span.className = `todo-item ${this._todo.isComplete? 'todo-done' : ''}`;
        
        const button = document.createElement('button');
        button.classList.add('del-button');
        button.innerText = 'X';

        this._elem.append(span, button);
        return this._elem;
    }

    onClick(event) {
        this._todo.isComplete = !this._todo.isComplete;
        this.render();
    }
}

export default TodoComponent;