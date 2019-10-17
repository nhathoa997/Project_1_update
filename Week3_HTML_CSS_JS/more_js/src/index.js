import { TodoApp } from './js/application';
import '../index.html';
import './css/main.css';

const app = new TodoApp(document.querySelector('#root'));
app.run();
